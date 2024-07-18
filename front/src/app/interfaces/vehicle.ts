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
    // TODO brandDto: BrandResponse
}
