import request from '@/utils/request'

// 查询院校详情列表
export function listFld(query) {
  return request({
    url: '/fld/fld/list',
    method: 'get',
    params: query
  })
}

// 查询院校详情详细
export function getFld(categoryId) {
  return request({
    url: '/fld/fld/' + categoryId,
    method: 'get'
  })
}

// 新增院校详情
export function addFld(data) {
  return request({
    url: '/fld/fld',
    method: 'post',
    data: data
  })
}

// 修改院校详情
export function updateFld(data) {
  return request({
    url: '/fld/fld',
    method: 'put',
    data: data
  })
}

// 删除院校详情
export function delFld(categoryId) {
  return request({
    url: '/fld/fld/' + categoryId,
    method: 'delete'
  })
}
