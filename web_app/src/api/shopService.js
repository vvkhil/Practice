import axios from "axios";

export async function getBaskShops() {
    const response = await axios.get('/shops');

    return response.data;
}

export async function getBaskShopById(id) {
    const response = await axios.get(`/shops/${id}`);

    return response.data;
}

export async function addBaskShop(id, title, rating, userId) {
    const response = await axios.post('/shops', {
        id,
        title,
        rating,
        userId
    });

    return response.data;
}

export async function updateBaskShop(id, title, rating) {
    const response = await axios.put('/shops', {
        id,
        title,
        rating
    });

    return response.data;
}

export async function removeBaskShopById(id) {
    const response = await axios.delete(`/shops/${id}`);

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