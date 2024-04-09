import axios from "axios";

export async function signIn(email, password) {
    const response = await axios.post(`/auth/signin?email=${email}&password=${password}`);

    return response.data;
}

export async function signUp(id, login, email, password) {
    const response = await axios.post('/auth/signup', {
        id,
        login,
        email,
        password
    });

    return response.data;
}