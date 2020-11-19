<template>
	<view>
		<uni-nav-bar left-icon="back" @clickLeft="backList" @clickRight="toFav" left-text="返回">
		</uni-nav-bar>
		<view>detail</view>
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
			backList() {
				uni.navigateTo({
					url: '/pages/home/list',
				});
			},
		},
	}
</script>

<style>

</style>
