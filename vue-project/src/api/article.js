import request from '@/util/request'
// 获取所有文章数据的函数
export function articleGetAllService(){
    // 同步等待服务器响应的结果并返回 async await
    return request.get("http://localhost:8080/article/getAll");
}
// 根据文章分类和发布状态搜索的函数
export function articleSearchService(conditions){
    return request.get("http://localhost:8080/article/search",{params:conditions});
}