export interface IJuice {
    id: number;
    title: string;
    descr: string;
    img: string;
    link?: string;
    _links: {
        self: {
            href: string;
        },
        juice: {
            href: string;
        }
    }
}
