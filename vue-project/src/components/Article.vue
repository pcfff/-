<script setup>
import { onMounted, ref } from 'vue';
import {articleGetAllService,articleSearchService} from '@/api/article.js'

let Articlelist = ref([]);
let searchConditions = ref({
    category:'',
    state:''
})

// 获取所有文章数据
// 同步获取articleGetAllService的返回结果 async await
const getAllArticle = async function(){
    let data = await articleGetAllService();
    Articlelist.value = data;    
}

getAllArticle();

let search = async function() {
    Articlelist.value = await articleSearchService({...searchConditions.value});
}
</script>

<template>
    <div>

文章分类: <input type="text" v-model="searchConditions.category">

发布状态: <input type="text" v-model="searchConditions.state"/>

<button @click="search">搜索</button>

<br />
<br />
<table border="1 solid" colspa="0" cellspacing="0">
    <tr>
        <th>文章标题</th>
        <th>分类</th>
        <th>发表时间</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <tr v-for="(article,index) in Articlelist">
        <td>{{ article.title }}</td>
        <td>{{ article.category }}</td>
        <td>{{ article.time }}</td>
        <td>{{ article.state }}</td>
        <td>
            <button>编辑</button>
            <button>删除</button>
        </td>
    </tr>
</table>
</div>

</template>

<style>

</style>