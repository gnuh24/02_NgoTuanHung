import { AxiosService } from "./AxiosService"
const urlGamer = "/Gamer"

const get = ()=> {
    return AxiosService.get(urlGamer);
}

const post = (data) => {
    return AxiosService.post(urlGamer, data);
}

const put = (id, data) => {
    return AxiosService.put(`${urlGamer}/${id}`, data)
}

const deleteGamer = (id) => {
    return AxiosService.delete(`${urlGamer}/${id}`)
}

export const GamerAPI = {
    get,
    post,
    put,
    deleteGamer
}