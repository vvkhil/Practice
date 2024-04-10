import { useContext, useState } from "react";
import { signUp } from "../api/authService";
import { AppContext } from "../contexts/contexts";
import { useNavigate } from "react-router-dom";
import './signup.css'

export default function Signup() {
    const appContext = useContext(AppContext);

    const navigate = useNavigate();

    const [id, setId] = useState('');
    const [login, setLogin] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    return (
        <section className="form-sign-up">
            <input
                className="form-control" 
                placeholder="Id"
                type="number"
                onChange={e => setId(e.target.value)}
            />
            <input
                className="form-control" 
                placeholder="Login"
                type="login"
                onChange={e => setLogin(e.target.value)}
            />
            <input
                className="form-control" 
                placeholder="Email"
                type="email"
                onChange={e => setEmail(e.target.value)}
            />
            <input
                className="form-control" 
                placeholder="Пароль"
                type="password"
                onChange={e => setPassword(e.target.value)}
            />
            <button
                className="btn btn-info"
                onClick={signupButtonOnClick}
            >
                Зарегистрироваться
            </button>
        </section>
    );

    async function signupButtonOnClick() {
        const data = await signUp(id, login, email, password);
        appContext.setCookie('userId', data.id);
        appContext.setCookie('token', data.token);
        appContext.setIsAuthenticated(true);
        navigate('/');
    }
}