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
export interface BrandResponse{
    id: number;
    name: string;
    categoty: string;
    deleted: boolean;
}

export enum BrandCategory {
    CAR = 'CAR',
    SPAREPART = 'SPAREPART',
    CAR_AND_SPAREPART = 'CAR_AND_SPAREPART'

}

//SERVICES
export interface ServiceRequest{
    clientId: number;
    vehicleId: number;
    sparePartsIds: number;
    employeesIds: number;
    serviceTypeId: number;
    startDate: Date;
    finalDate: Date;
    status: StatusService;
}

export enum StatusService{
    TO_DO = 'TO_DO', 
    IN_PROGRESS = 'IN_PROGRESS', 
    FINISHED = 'FINISHED', 
    CANCELLED = 'CANCELED'
}

export interface ServiceResponse{
    id: number;
    serviceType: ServiceTypeResponse;
    status: StatusService;
    payDate: Date;
    price: number;
    startDate: Date;
    finalDate: Date;
    vehicle: VehicleBasicResponse;
    client: ClientBasicResponse;
    employees: EmployeeBasicResponse;
    spareParts: SparePartResponse;
}

export interface ServiceTypeResponse{
    id: number;
    name: string;
    description: string;
    isDeleted: boolean;
}

export interface VehicleBasicResponse{
    plate: string;
    model: string;
    mileage: number;
    observations: string;
    brand: BrandResponse;
}

export interface ClientBasicResponse{
    id: number;
    name: string;
    lastName: string;
    category: DocumentType;
    identificationNumber: number;
    email: string;
    businessName?: string;
    deleted?: boolean;
}

export interface EmployeeBasicResponse {
    id: number;
    name: string;
    lastName: string;
}

export interface SparePartResponse {
    id: number;
    name: string;
    brand: BrandResponse;
    madeIn: string;
    isDeleted: boolean;
}

export interface BrandResponse{
    id: number;
    name: string;
    category: BrandCategory;
    isDeleted: boolean;
}
