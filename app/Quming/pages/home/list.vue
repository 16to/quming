<template>
	<view>
	<uni-nav-bar left-icon="back" @clickLeft="backHome" @clickRight="favorite" left-text="返回" right-text="收藏列表" title="名字列表"></uni-nav-bar>
	<view>
		123
	</view>
	</view>
</template>

<script>
	import uniNavBar from "@/components/uni-nav-bar/uni-nav-bar.vue"
	export default {
		components: {uniNavBar},
		data() {
			return {
				nbTitle: '标题',
				titleIcon: '/static/logo.png',
				titleIconRadius: '20px',
				subtitleText: 'subtitleText',
				nbLoading: false,
				nbFrontColor: '#000000',
				nbBackgroundColor: '#ffffff'
			}
		},
		methods: {
			backHome(){
				console.log(123);
				// 跳转到 tabBar 页面只能使用 switchTab 跳转
				uni.switchTab({
					url: '/pages/home/index',
				});
				// uni.navigateBack({
				// 	delta: 1
				// })
			},
			favorite(){
				console.log(456);
				uni.navigateTo({
					url: '/pages/home/favorite',
				});
			}
		}
	}
	
</script>

<style>

</style>
