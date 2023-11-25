import request from '@/utils/request'

// 查询院校专业介绍列表
export function listZyjsinfos(query) {
  return request({
    url: '/zyjsinfos/zyjsinfos/list',
    method: 'get',
    params: query
  })
}

// 查询院校专业介绍详细
export function getZyjsinfos(dicCurId) {
  return request({
    url: '/zyjsinfos/zyjsinfos/' + dicCurId,
    method: 'get'
  })
}

// 新增院校专业介绍
export function addZyjsinfos(data) {
  return request({
    url: '/zyjsinfos/zyjsinfos',
    method: 'post',
    data: data
  })
}

// 修改院校专业介绍
export function updateZyjsinfos(data) {
  return request({
    url: '/zyjsinfos/zyjsinfos',
    method: 'put',
    data: data
  })
}

// 删除院校专业介绍
export function delZyjsinfos(dicCurId) {
  return request({
    url: '/zyjsinfos/zyjsinfos/' + dicCurId,
    method: 'delete'
  })
}
