import axios from "axios";

export async function getBaskShops() {
    const response = await axios.get('/shops');

    return response.data;
}

export async function getBaskShopById(id) {
    const response = await axios.get(`/shops/${id}`);

    return response.data;
}

export async function addBaskShop(shop) {
    const response = await axios.post('/shops/add/', shop);

    return response.data;
}

export async function updateBaskShop(shop) {
    const response = await axios.put('/shops/update/' + shop.id, shop);

    return response.data;
}

export async function removeBaskShopById(id) {
    const response = await axios.delete(`/shops/${id}`);

    return response.data;
}

export async function getShopsByShoeId(shoeId) {
    const response = await axios.get(`/shops/${shoeId}/shoes`);

    return response.data;
}

export async function addShoeToShop(shopId, shoeId) {
    const response = await axios.post(`/shops/${shopId}/shoes/${shoeId}`)

    return response.data;
}

export async function removeShoeFromShop(shopId, shoeId) {
    const response = await axios.delete(`/shops/${shopId}/shoes/${shoeId}`)

    return response.data;
}