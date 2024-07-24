// CLIENT
export interface ClientRequest{
    name: string;
    lastName: string;
    category: DocumentType;
    identificationNumber: number;
    email: string;
    businessName?: string;
}

export interface ClientResponse{
    id: number;
    name: string;
    lastName: string;
    category: DocumentType;
    identificationNumber: number;
    email: string;
    businessName?: string;
    deleted?: boolean;
    //TODO agregar servicios vinculados, cuando esten disponibles
}

export enum DocumentType {
    DNI = 'DNI',
    CUIT = 'CUIT'
}

//VEHICLE
export interface VehicleRequest{
    plate: string;
    brandId: number;
    model: string;
    mileage: number;
    observations: string;
}

export interface VehicleResponse{
    id: number;
    plate: string;
    model: string;
    mileage: number;
    observations: string;
    deleted: boolean;
    brand: BrandResponse;
}

//BRAND
export interface BrandRequest{
    name: string;
    category: BrandCategory;
}

export interface BrandResponse{
    id: number;
    name: string;
    category: BrandCategory;
    deleted: boolean;
}

export enum BrandCategory {
    CAR = 'CAR',
    SPAREPART = 'SPAREPART',
    CAR_AND_SPAREPART = 'CAR_AND_SPAREPART'
}
