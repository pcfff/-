import request from '@/utils/request'
import { useTokenStore } from '@/stores/token'
// 文章分类列表查询
export const ArticleCategoryListService = ()=>{
    //const tokenStore = useTokenStore();

    //return request.get('/category',{headers:{'Authorization':tokenStore.token}})

    return request.get('/category')
}

export const ArticleCategoryAddService = (categoryData)=>{
    return request.post('/category',categoryData)
}

// 文章分类修改
export const ArticleCategoryUpdateService = (categoryData)=>{
    return request.put('/category',categoryData)
}

// 文章分类删除
export const ArticleCategoryDeleteService = (id)=>{
    return request.delete('/category?id='+id);
}

// 文章列表查询
export const articleListService = (params)=>{
    return request.get('/article',{params:params})
}