import React, { useState, useEffect, useContext } from 'react';
import { getBaskShops, removeBaskShopById, getBaskShopById, addBaskShop, updateBaskShop, getShopsByShoeId, addShoeToShop, removeShoeFromShop } from "../api/shopService"
import { getBaskShoe } from "../api/shoeService"
import { Link, useLoaderData, useNavigate } from "react-router-dom";
import Select  from "react-select";
import { AppContext } from '../contexts/contexts';

export async function loader({ params }) {
    const shop = await getBaskShopById(params.shopId);
    return { shop };
}

export default function Shops() {
    const [shops, setShops] = useState([]);
    const [reload, setReload] = useState(false);

    const appContext = useContext(AppContext)

    useEffect(() => {
        loadShops()
    }, [reload]);

    return (
        <section >
            <div>
                <h2>Shops</h2>
                
                <table className="table table-striped table-hover">   
                    <thead>
                        <tr>
                            <th>
                                Title
                            </th>
                            <th>
                                Rating
                            </th>
                            <th>
                                <Link to="add/" className="btn btn-success">Добавить</Link>
                            </th>
                            <th>
                                <Link to="add/" className="btn btn-success">Добавить</Link>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        {shops.map(shop =>
                            <tr key={shop.id}>
                                <td>
                                    {shop.title}
                                </td>
                                <td>
                                    {shop.rating}
                                </td>
                                <td>
                                    <Link to={`update/${shop.id}`} className="btn btn-info">Изменить</Link>
                                    |
                                    <button 
                                        onClick={() => removeBaskShop(shop.id)} 
                                        value={shop.id} 
                                        className="btn btn-danger">
                                            Удалить
                                    </button>
                                </td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        </section>
    );

    async function loadShops() {
        const shops = await getBaskShops()
        console.log(shops)
        setShops(shops)
    }

    async function removeBaskShop(id) {
        await removeBaskShopById(id)
        setReload(!reload)
    }
}

export function BaskShopAdd() {
    const navigate = useNavigate();

    const [id, setId] = useState('');
    const [title, setTitle] = useState('');
    const [rating, setRating] = useState('');
    const [shoes, setShoes] = useState();

    const appContext = useContext(AppContext);

    let shoesList = [];

    loadShoes();

    return (
        <section class="form-container">
            <div class="form">
                <input
                    placeholder="Id"
                    class="form-control"
                    type="number"
                    onChange={(e) => setId(e.target.value)}
                />
                <input
                    placeholder="Название"
                    class="form-control"
                    type="text"
                    onChange={(e) => setTitle(e.target.value)}
                />
                <Select
                    options={shoesList}
                    placeholder="Shoes"
                    value={shoes}
                    onChange={handleSelectShoe}
                    isSearchable={true}
                    isMulti
                />
                <input
                    placeholder="Rating"
                    class="form-control"
                    type="number"
                    onChange={(e) => setRating(e.target.value)}
                />
                <button
                    onClick={addBaskShopClick}>
                    Добавить
                </button>
            </div>
        </section>
    );

    function handleSelectShoe(data) {
        setShoes(data);
    }

    async function loadShoes() {
        const shoes = await getBaskShoe()
        shoes.map(shoe =>
            shoesList.push({ value: shoe, label: shoe.title})    
        )
    }

    async function addBaskShopClick() {
        let shop = {}
        shop.id = id
        shop.title = title
        shop.rating = rating
        shop.user = appContext.user
        // shop.shoes = shoes.map(shoe => shoe.value)
        console.log(shop)
        await addBaskShop(shop)
        navigate('/shops')
    }
}

export function ShopsUpdate() {
    const navigate = useNavigate();

    const { shop } = useLoaderData();
    const [title, setTitle] = useState('');
    const [rating, setRating] = useState('');
    const [shoes, setShoes] = useState();

    const appContext = useContext(AppContext);

    let shoesList = [];

    loadShoes();

    return (
        <section class="form-container">
            <div class="form">
                <input
                    placeholder="Название"
                    class="form-control"
                    type="text"
                    onChange={(e) => setTitle(e.target.value)}
                />
                <input
                    placeholder="Rating"
                    class="form-control"
                    type="number"
                    onChange={(e) => setRating(e.target.value)}
                />
                <Select
                    options={shoesList}
                    placeholder="Shoes"
                    onChange={handleSelectShoe}
                    isSearchable={true}
                    isMulti
                />
                <button
                    onClick={updateBaskShopClick}>
                    Изменить
                </button>
            </div>
        </section>
    );

    function handleSelectShoe(data) {
        setShoes(data);
    }

    async function loadShoes() {
        const shoes = await getBaskShoe()
        shoes.map(shoe =>
            shoesList.push({ value: shoe, label: shoe.title})    
        )
    }

    async function updateBaskShopClick() {
        shop.title = title
        shop.rating = rating
        shop.user = appContext.user
        // shop.shoes = shoes.map(shoe => shoe.value)
        await updateBaskShop(shop)
        navigate('/shops')
    }
}

export function AddShoeToShop() {
    const navigate = useNavigate();

    const [shops, setShops] = useState();
    const [shoes, setShoes] = useState();

    const appContext = useContext(AppContext);

    let shopsList = [];
    let shoesList = [];

    loadShops();
    loadShoes();

    return (
        <section class="form-container">
            <div class="form">
                <Select
                    options={shopsList}
                    placeholder="Shops"
                    value={shops}
                    onChange={handleSelectShop}
                    isSearchable={true}
                    isMulti
                />
                <Select
                    options={shoesList}
                    placeholder="Shoes"
                    value={shoes}
                    onChange={handleSelectShoe}
                    isSearchable={true}
                    isMulti
                />
                <button
                    onClick={addBaskShopClick}>
                    Добавить
                </button>
            </div>
        </section>
    );

    function handleSelectShop(data) {
        setShops(data);
    }

    function handleSelectShoe(data) {
        setShoes(data);
    }

    async function loadShops() {
        const shops = await getBaskShops()
        shops.map(shop =>
            shopsList.push({ value: shop, label: shop.id})    
        )
    }

    async function loadShoes() {
        const shoes = await getBaskShoe()
        shoes.map(shoe =>
            shoesList.push({ value: shoe, label: shoe.id})    
        )
    }

    async function addBaskShopClick() {
        let shop = {}
        shop.id = id
        shop.title = title
        shop.rating = rating
        shop.user = appContext.user
        // shop.shoes = shoes.map(shoe => shoe.value)
        console.log(shop)
        await addBaskShop(shop)
        navigate('/shops')
    }
}