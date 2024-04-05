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
