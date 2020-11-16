<template>
	<view class="page">
		<view class="uni-margin-wrap">
			<swiper class="swiper" circular :indicator-dots="indicatorDots" :autoplay="autoplay" :interval="interval" :duration="duration">
				<swiper-item v-for="v in banner" :key="v.id">
					<view class="swiper-item">
						<image class="image" mode="widthFix" :src='uplaodPath+v.img' />
					</view>
				</swiper-item>
			</swiper>
		</view>
		<view class="qm-form">
			<form @submit="formSubmit">
				<view class="uni-list">
					<view class="uni-list-cell">
						<view class="uni-list-cell-left">
							性别
						</view>
						<view class="uni-list-cell-db">
							<radio-group name="sex">
								<label>
									<radio value="man" checked="" /><text>男</text>
								</label>
								<label>
									<radio value="feman" /><text>女</text>
								</label>
							</radio-group>
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-list-cell-left">
							姓氏
						</view>
						<view class="uni-list-cell-db">
							<input class="uni-input" name="fname" placeholder="这是一个输入框" />
						</view>
					</view>
					<view class="uni-list-cell">
						<view class="uni-list-cell-left">
							日期
						</view>
						<view class="uni-list-cell-db">
							<MyDatetimePicker fields="hour" @change="dateTimeChange" />
						</view>
					</view>
				</view>
				<view class="uni-btn-v">
					<button form-type="submit">点击取名</button>
				</view>
			</form>
		</view>
	</view>
</template>

<script>
	import MyDatetimePicker from '@/components/datetime-picker/datetime-picker.vue';
	export default {
		components: {
			MyDatetimePicker
		},
		data() {
			return {
				uplaodPath: this.$api.uploadRoot,
				indicatorDots: false,
				autoplay: true,
				interval: 3000,
				duration: 500,
				birthday: '',
				banner: [],
			}
		},
		// 当页面加载之后
		onLoad() {
			// 获取banner
			uni.request({
				url: this.$api.home.banner,
				method: 'GET',
				data: {},
				success: res => {
					this.banner = res.data;
				},
				fail: () => {},
				complete: () => {}
			});
		},
		methods: {
			formSubmit: function(e) {
				console.log('form发生了submit事件，携带数据为：' + JSON.stringify(e.detail.value))
				let formdata = e.detail.value;
				formdata.birthday = this.birthday;
				formdata.client = "H5";
				console.log(formdata);
				uni.showModal({
					content: '表单数据内容：' + JSON.stringify(formdata),
					showCancel: false
				});
				this.sendDate(formdata);
			},
			// 年月日时变化
			dateTimeChange(date) {
				console.log(date);
				this.birthday = date.f3;
			},
			// 发送请求数据
			sendDate(data) {
				uni.request({
					url: this.$api.home.postor,
					method: 'POST',
					data: data,
					success: res => {
						console.log(res);
						// 跳转到列表页
						uni.navigateTo({
							url: '/pages/home/list',
						});
					},
					fail: () => {},
					complete: () => {}
				});
			}
		}
	}
</script>

<style>
	.uni-margin-wrap {
		/* width:690rpx; */
		margin: 0 30rpx;
	}

	.swiper {
		height: 300rpx;
	}

	.swiper-item {
		display: block;
		height: 300rpx;
		line-height: 300rpx;
		text-align: center;
	}

	.swiper-list {
		margin-top: 40rpx;
		margin-bottom: 0;
	}

	.uni-common-mt {
		margin-top: 60rpx;
		position: relative;
	}

	.info {
		position: absolute;
		right: 20rpx;
	}

	.uni-padding-wrap {
		width: 550rpx;
		padding: 0 100rpx;
	}
</style>
