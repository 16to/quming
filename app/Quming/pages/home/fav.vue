<template>
	<view>
		<uni-nav-bar left-icon="back" @clickLeft="backUser" left-text="返回" title="我的收藏">
		</uni-nav-bar>
		<view>我的收藏</view>
	</view>
</template>

<script>
	import uniNavBar from "@/components/uni-nav-bar/uni-nav-bar.vue"
	export default {
		components: {
			uniNavBar,
		},
		data() {
			return {

			}
		},
		methods: {
			backUser() {
				uni.switchTab({
					url: '/pages/user/index',
				});
			},
		},
	}
</script>

<style>

</style>
