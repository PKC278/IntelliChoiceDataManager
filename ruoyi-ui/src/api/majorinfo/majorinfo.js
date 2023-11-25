import request from '@/utils/request'

// 查询专业详情列表
export function listMajorinfo(query) {
  return request({
    url: '/majorinfo/majorinfo/list',
    method: 'get',
    params: query
  })
}

// 查询专业详情详细
export function getMajorinfo(zydm) {
  return request({
    url: '/majorinfo/majorinfo/' + zydm,
    method: 'get'
  })
}

// 新增专业详情
export function addMajorinfo(data) {
  return request({
    url: '/majorinfo/majorinfo',
    method: 'post',
    data: data
  })
}

// 修改专业详情
export function updateMajorinfo(data) {
  return request({
    url: '/majorinfo/majorinfo',
    method: 'put',
    data: data
  })
}

// 删除专业详情
export function delMajorinfo(zydm) {
  return request({
    url: '/majorinfo/majorinfo/' + zydm,
    method: 'delete'
  })
}
