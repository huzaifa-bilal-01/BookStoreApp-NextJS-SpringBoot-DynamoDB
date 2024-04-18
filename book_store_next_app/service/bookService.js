import axios from "axios";


const axiosClient = axios.create();
axiosClient.defaults.baseURL = "http://127.0.0.1:8080";

export async function getBooks(URL) {
    const response = await axiosClient.get(URL)
    .then(response => response)
    .catch(error => console.log(error))

    return response.data;

}

export async function putBooks(URL, payload) {
    const response = await axiosClient.put(URL, payload)
    .then(response => response)
    .catch(error => console.log(error))

    return response.data;
}

export async function postBooks(URL, payload) {
    const response = await axiosClient.post(URL, payload)
    .then(response => response)
    .catch(error => console.log(error))

    return response.data;
}

export async function deleteBooks(URL) {
    const response = await axiosClient.delete(URL)
    .then(response => response)
    .catch(error => console.log(error))

    return response.data;
}