import request from '@/utils/request'

// 查询院校列表列表
export function listColleges(query) {
  return request({
    url: '/colleges/colleges/list',
    method: 'get',
    params: query
  })
}

// 查询院校列表详细
export function getColleges(yxdm) {
  return request({
    url: '/colleges/colleges/' + yxdm,
    method: 'get'
  })
}

// 新增院校列表
export function addColleges(data) {
  return request({
    url: '/colleges/colleges',
    method: 'post',
    data: data
  })
}

// 修改院校列表
export function updateColleges(data) {
  return request({
    url: '/colleges/colleges',
    method: 'put',
    data: data
  })
}

// 删除院校列表
export function delColleges(yxdm) {
  return request({
    url: '/colleges/colleges/' + yxdm,
    method: 'delete'
  })
}
