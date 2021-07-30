package com.apigateway.DnsFixer;

import org.springframework.cloud.gateway.config.HttpClientCustomizer;
import org.springframework.stereotype.Component;

import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.netty.http.client.HttpClient;

@Component
public class DnsResolutionFixer implements HttpClientCustomizer {
// Tip: This was used bacause of geting unknownHostException and dns

	// java.net.UnknownHostException: failed to resolve 'Ghost-Riders' at
	// io.netty.resolver.dns.DnsResolveContext.finishResolve(DnsResolveContext.java:1013)
	// ~[netty-resolver-dns-4.1.63.Final.jar:4.1.63.Final] Suppressed:
	// reactor.core.publisher.FluxOnAssembly$OnAssemblyException: Error has been
	// observed at the following site(s): |_ checkpoint ⇢
	// org.springframework.cloud.gateway.filter.WeightCalculatorWebFilter
	// [DefaultWebFilterChain] |_ checkpoint ⇢ HTTP GET
	// "/student-service/api/student/getById/1" [ExceptionHandlingWebHandler] Stack
	@Override
	public HttpClient customize(HttpClient httpClient) {
		return httpClient.resolver(DefaultAddressResolverGroup.INSTANCE);
	}

}
