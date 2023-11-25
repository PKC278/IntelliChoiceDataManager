import request from '@/utils/request'

// 查询专业列表列表
export function listMajor(query) {
  return request({
    url: '/major/major/list',
    method: 'get',
    params: query
  })
}

// 查询专业列表详细
export function getMajor(CategoryID) {
  return request({
    url: '/major/major/' + CategoryID,
    method: 'get'
  })
}

// 新增专业列表
export function addMajor(data) {
  return request({
    url: '/major/major',
    method: 'post',
    data: data
  })
}

// 修改专业列表
export function updateMajor(data) {
  return request({
    url: '/major/major',
    method: 'put',
    data: data
  })
}

// 删除专业列表
export function delMajor(CategoryID) {
  return request({
    url: '/major/major/' + CategoryID,
    method: 'delete'
  })
}
