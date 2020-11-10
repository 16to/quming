<template>
	<view class="page">
{{title}}
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: '首页访问记录',
			}
		},
		// 当页面加载之后
		onLoad() {
			uni.showLoading({
				title: '加载中',
			})
			uni.request({
				url: 'http://qmadmin.16to.com/api/visitor',
				method: 'POST',
				data: {
					"client":"H5",
				},
				success: res => {
					console.log(res);
					uni.hideLoading();
				},
				fail: () => {},
				complete: () => {}
			});
		},
	}
</script>