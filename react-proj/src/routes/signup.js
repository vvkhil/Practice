import { useContext, useState } from "react";
import { signUp } from "../api/authService";
import { AppContext } from "../contexts/contexts";
import { useNavigate } from "react-router-dom";

export default function Signup() {
    const appContext = useContext(AppContext);

    const navigate = useNavigate();

    const [login, setLogin] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    return (
        <section>
            <input
                placeholder="Login"
                type="login"
                onChange={e => setLogin(e.target.value)}
            />
            <input
                placeholder="Email"
                type="email"
                onChange={e => setEmail(e.target.value)}
            />
            <input
                placeholder="Пароль"
                type="password"
                onChange={e => setPassword(e.target.value)}
            />
            <button
                onClick={signupButtonOnClick}
            >
                Зарегистрироваться
            </button>
        </section>
    );

    async function signupButtonOnClick() {
        const data = await signUp(login, email, password);
        appContext.setCookie('userId', data.id);
        appContext.setCookie('token', data.token);
        appContext.setIsAuthenticated(true);
        navigate('/');
    }
}