import request from '../Utils/request'

export const userListService= (params) =>{
   return request.get('/user',{params:params})
}