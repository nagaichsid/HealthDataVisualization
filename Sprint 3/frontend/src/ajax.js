import fetch from 'isomorphic-fetch';

export default async function ajax(endpoint) {
    const headers = {'Content-Type': 'application/json'};
    const response = await fetch(endpoint, {
        method: 'GET',
        headers,
    });
    let body = await response.text();
    return JSON.parse(body);
}