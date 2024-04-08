import axios from "axios"

export async function getUsers() {
    const response = await axios.get('/users');

    return response.data;
}

export async function getUserById(id) {
    const response = await axios.get(`/users/${id}`);

    return response.data;
}

export async function getUserAppByRoleId(id) {
    const response = await axios.get(`/roles/${id}/users`);

    return response.data;
}

export async function updateUser(id, login, email, password, roleId) {
    const response = await axios.put('/users', {
        id,
        login,
        email,
        password,
        roleId
    });

    return response.data;
}

export async function removeUserById(id) {
    const response = await axios.delete(`/users/${id}`);

    return response.data;
}