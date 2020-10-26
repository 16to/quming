<template>
	<view class="content">
		<view class="uni-list">
			<view class="uni-list-cell" hover-class="uni-list-cell-hover" v-for="(item,index) in news" :key="index" @click="openinfo"
			 :data-newsid="item.post_id">
				<view class="uni-media-list">
					<image class="uni-media-list-logo" :src="item.author_avatar"></image>
					<view class="uni-media-list-body">
						<view class="uni-media-list-text-top">{{item.title}}</view>
						<view class="uni-media-list-text-bottom uni-ellipsis">{{item.created_at}}</view>
					</view>
				</view>
			</view>
		</view>
		这是取名应用的第一行代码
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Demo',
				news: [],
			}
		},
		// 当页面加载之后
		onLoad() {
			uni.showLoading({
				title: '加载中',
			})
			uni.request({
				url: 'https://unidemo.dcloud.net.cn/api/news',
				method: 'GET',
				data: {},
				success: res => {
					this.news = res.data;
					uni.hideLoading();
				},
				fail: () => {},
				complete: () => {}
			});
		},
		methods: {
			openinfo(e) {
				var newsid = e.currentTarget.dataset.newsid;
				uni.navigateTo({
					url: '../info/info?newsid=' + newsid
				});
			}
		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}
</style>
