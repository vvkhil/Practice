import { useContext, useState } from "react";
import { signIn } from "../api/authService";
import { AppContext } from "../contexts/contexts";
import { useNavigate } from "react-router-dom";
import './signin.css'

export default function Signin() {
    const appContext = useContext(AppContext);
    
    const navigate = useNavigate();
    
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const isValidEmail = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g;

    return (
        <section className="form-sign-in">
            <input
                id="input-email"
                className="form-control" 
                aria-label="Small" 
                aria-describedby="inputGroup-sizing-sm"
                placeholder="Email"
                type="email"
                onChange={e => 
                    {
                        if(e.target?.value && e.target.value.match(isValidEmail)){
                            console.log('valid')
                            setEmail(e.target.value)
                        }else{
                            console.log('invalid')
                        }
                    }
                }
            />
            <input
                className="form-control" 
                aria-label="Small" 
                aria-describedby="inputGroup-sizing-sm"
                placeholder="Пароль"
                type="password"
                onChange={e => setPassword(e.target.value)}
            />
            <button
                className="btn btn-info"
                onClick={signinButtonOnClick}
            >
                Войти
            </button>
        </section>
    );

    async function signinButtonOnClick() {
        const data = await signIn(email, password);
        console.log(email);
        console.log(password);
        appContext.setCookie('userId', data.id);
        appContext.setCookie('token', data.token);
        appContext.setIsAuthenticated(true);
        navigate('/');
    }
}