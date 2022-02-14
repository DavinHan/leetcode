package com.hyan.demo;

/**
 * 网关Filter
 *
 * @author yanhanf
 */
public class DefaultMyGatewayFilter {

    public void doFilter() throws Exception {
        try {
            this.init();

            try {
                this.preRouting();
            } catch (Exception e) {
                this.postRouting();
                routeErr(e);
                return;
            }

            try {
                this.routing();
            } catch (Exception e) {
                routeErr(e);
                return;
            }

            this.postRouting();
        } catch (Throwable ignored) {

        }
    }

    /**
     * 初始化
     */
    private void init(){};

    /**
     * 预加载，预验证，如：安全验证、参数验证、身份验证
     */
    private void preRouting() throws Exception {};

    /**
     * 路由，真实的请求路由
     */
    private void routing() throws Exception {};

    /**
     * 路由后的处理，如数据收集、统计信息、统计指标
     */
    private void postRouting() throws Exception {};

    /**
     * 统一的路由错误处理
     * @param e 异常
     */
    private void routeErr(Exception e) {};
}
