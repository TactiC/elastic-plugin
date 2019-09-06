package nl.ronalddehaan;

import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.rest.*;

import java.io.IOException;

public class SimpleRestHandler extends BaseRestHandler {

  private static String NAME = "_hello";

  @Inject
  public SimpleRestHandler(Settings settings, RestController restController) {
    super(settings);
    restController.registerHandler(RestRequest.Method.GET, "/" + NAME, this);
  }

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
    return channel -> {
      XContentBuilder builder = channel.newBuilder();
      builder.startObject().field("message", "Hello World!").endObject();
      channel.sendResponse(new BytesRestResponse(RestStatus.OK, builder));
    };
  }
}
