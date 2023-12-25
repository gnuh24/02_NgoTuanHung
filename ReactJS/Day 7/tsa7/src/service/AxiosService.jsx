import axios from "axios";
export const AxiosService = axios.create({
    baseURL: "https://6528c32d931d71583df26e60.mockapi.io",
    timeout: 5000
});