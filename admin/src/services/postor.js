import { stringify } from 'qs';
import request from '@/utils/request';

// 获取数据
export async function getList(params) {
  return request(`/api/postor?${stringify(params)}`);
}