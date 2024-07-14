export interface CustomPage<T> {
    content: T[];
    pageNumber: number;
    pageSize: number;
    totalPages: number;
    totalElements: number;
    first: boolean;
    last: boolean;
    numberOfElements: number;
}

export interface PageParams {
    page: number;
    size: number;
    sort?: string;
}
