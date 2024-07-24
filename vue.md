### 多根元素的透传属性和事件

```vue
<script setup>
import Chip from './components/Chip.vue';

function say(){
  alert('Hello')
}
</script>

<template>
  <!-- 透传的属性style class title 在子组件中并没有在props中声明 -->
   
  <Chip
    class="rounded"
    style="border: 1px solid blue"
    title="纸片"
    @click="say"
  />
</template>

<style>

</style>
```

```vue
<script setup>
</script>

<template>
    <!-- 
        多根节点的组件并没有自动“透传属性和事件”的行为
        由于vue不确定要将“透传属性和事件”透传到哪里
        所以我们需要v-bind="$attrs"来显式绑定，否则将会抛出一个运行时警告 
    -->
    <button class="chip"  v-bind="$attrs">
        普通纸片1
    </button>

    <button class="chip">
        普通纸片2
    </button>

    <button class="chip" v-bind="$attrs">
        普通纸片3
    </button>
</template>

<style>
.chip{
    border: none;
    background-color: grey;
    padding: 8px 15px;
    margin: 10px;
}

.rounded{
    border-radius: 100px;
}
</style>
```

### 访问透传的属性和事件

```vue
<script setup>
import Chip from './components/Chip.vue';

function say(){
  alert('Hello')
}
</script>

<template>
  <!-- 透传的属性style class title 在子组件中并没有在props中声明 -->
   
  <Chip
    class="rounded"
    style="border: 1px solid blue"
    title="纸片"
    @click="say"
  />
</template>

<style>

</style>
```

```vue
<script setup>
import { useAttrs } from 'vue';

// 透传的属性和事件对象
let attrs = useAttrs()

// 在js中访问透传的属性和事件
function showAttrs(){
    console.log(attrs);
    console.log(attrs.class);
    console.log(attrs.title);
    console.log(attrs.style);
    attrs.onClick()
}
</script>

<template>
    <button class="chip"  v-bind="$attrs">
        普通纸片
    </button>

    <hr>
    <h6>{{ $attrs }}</h6>
    <ul>
        <li>{{ $attrs.title }}</li>
        <li>{{ $attrs.class }}</li>
        <li>{{ $attrs.style }}</li>
    </ul>
    <button @click="showAttrs">在js中访问透传的属性和事件</button>
</template>

<style>
.chip{
    border: none;
    background-color: grey;
    padding: 8px 15px;
    margin: 10px;
}

.rounded{
    border-radius: 100px;
}
</style>
```

### 组件 - 插槽

```vue
<script setup>
import Card from './components/Card.vue';
</script>

<template>
  <Card> 
    <!-- 向具名插槽提供内容 -->
    <template v-slot:cardtitle>
      博客
    </template> 

    <template #cardsubtitle>
      <i>百万博主分享经验</i>
    </template> 

    <template #cardcontent="dataProps">
      <ul>
        <!-- <li>{{ dataProps }}</li> -->
        <li>
          博客的标题：{{ dataProps.cardBlog.title }}
        </li>
        <li>
          博客的时间：{{ dataProps.cardBlog.time }}
        </li>
        <li>
          博主：{{ dataProps.cardAuthor }}              
        </li>
      </ul>
    </template>
    <!-- 向子组件默认插槽中提供内容 -->
    <!-- <button>关闭</button> -->
     <template #default>
      <button>关闭</button>
     </template>
  </Card>

  <hr>
  <!-- 如果使用子组件时用到了v-slot 则该子组件标签中将无法向其他具名插槽中提供内容 -->
  <Card v-slot="dataProps">
    <button>{{ dataProps.close }}</button>
    <button>{{ dataProps.sure }}</button> 
  </Card>
</template>

<style>

</style>
```

```vue
<script setup>
import { reactive, ref } from 'vue';

let blog = reactive({
    title:'Java 如何实现上传文件',
    time:'2021-12-25 15:33:25'
})

let author = ref('爱思考的飞飞')

let closeBtn = ref('关闭')
let determine = ref('确定')

</script>

<template>
    <div class="card">
        <h2 class="title">
            <!-- 带有name属性的插槽，称为具名插槽 -->
            <slot name="cardtitle"></slot>
        </h2>
        <div class="subtitle">
            <slot name="cardsubtitle"></slot>
        </div>
        <!-- 在声明插槽时使用属性值的方式来传递子组件的数据，这种带有数据的插槽称为作用域插槽 -->
        <div class="content">
            <!-- slot插槽上的name是一个Vue特别保留的属性，不会在作用域插槽中访问到 -->
            <slot name="cardcontent" :cardBlog="blog" :cardAuthor="author"></slot>
        </div>
        <div class="action">
            <!-- 定义一个插槽 -->
             <!-- 插槽的默认内容，只有没有提供内容时才会显示 -->
              <!-- 没有name属性的插槽称为默认插槽，会有一个隐含的名字叫default -->
            <slot :close="closeBtn" :sure="determine">卡片功能区</slot>
        </div>
    </div>
</template>

<style>
.card{
    width: 450px;
    border: 1px solid black;
    padding:10px
}
.card h2, .card div{
    margin: 10px;
    padding:5px;
}

.title{
    border: 1px solid red;
}

.subtitle{
    border: 1px solid green;
}

.content{
    border: 1px solid blue;
}

.action{
    border: 1px solid pink;
}
</style>
```

