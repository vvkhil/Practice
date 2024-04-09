import axios from "axios"


export async function getBaskShoe() {
    const response = await axios.get('/shoes');

    return response.data;
}

export async function getBaskShoeById(id) {
    const response = await axios.get(`/shoes/${id}`);

    return response.data;
}

export async function getShoesByShopId(shopId, isInShop) {
    const response = await axios.get(`/shops/${shopId}/shoes?isInShop=${isInShop}`);

    return response.data;
}

export async function addBaskShoe(shoe) {
    const response = await axios.post('/shoes/add/', shoe);

    return response.data;
}

export async function updateBaskShoe(shoe) {
    const response = await axios.put('/shoes/update/' + shoe.id, shoe);

    return response.data;
}

export async function removeBaskShoeById(id) {
    const response = await axios.delete(`/shoes/${id}`);

    return response.data;
}

