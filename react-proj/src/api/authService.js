import axios from "axios";

export async function signIn(email, password) {
    const response = await axios.post(`/auth/signin?email=${email}&password=${password}`);

    return response.data;
}

export async function signUp(login, email, password, roleId) {
    const response = await axios.post('/auth/signup', {
        login,
        email,
        password,
        roleId
    });

    return response.data;
}