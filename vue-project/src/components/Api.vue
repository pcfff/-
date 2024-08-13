<script setup>
import { onMounted, ref } from 'vue';

// 声明响应式数据
let count = ref(0);
function fn(){
    count.value++;
}

// 声明钩子函数
onMounted(()=>{
    console.log("Vue已经挂载完毕了");
    
})
</script>

<template>
    <!-- 写html元素 -->
    <button @click="fn">count:{{ count }}</button>
</template>