package nl.ronalddehaan.plugin;

import nl.ronalddehaan.SimpleRestHandler;
import nl.ronalddehaan.filter.FilterFactory;
import org.elasticsearch.cluster.metadata.IndexNameExpressionResolver;
import org.elasticsearch.cluster.node.DiscoveryNodes;
import org.elasticsearch.common.settings.ClusterSettings;
import org.elasticsearch.common.settings.IndexScopedSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.settings.SettingsFilter;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.ActionPlugin;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestHandler;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class RemoveTokenPlugin extends Plugin implements AnalysisPlugin, ActionPlugin {

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> extra = new LinkedHashMap<>();
        extra.put("remove-first-token", FilterFactory::new);
        return extra;
    }

    @Override
    public List<RestHandler> getRestHandlers(final Settings settings,
                                           final RestController restController,
                                           final ClusterSettings clusterSettings,
                                           final IndexScopedSettings indexScopedSettings,
                                           final SettingsFilter settingsFilter,
                                           final IndexNameExpressionResolver indexNameExpressionResolver,
                                           final Supplier<DiscoveryNodes> nodesInCluster) {
      return Collections.singletonList(new SimpleRestHandler(settings, restController));
    }
}
