import { IJuice } from "./juice"

export interface ResponseUser {
    _embedded: {
        juices: IJuice[] 
    },
    _links: {
        self: {
            href: string;
        },
        profile: {
            href: string;
        }
    },
    page: {
        size: number;
        totalElements: number;
        totalPages: number;
        number: number;
    }
}
