import api from './index'
import {AxiosResponse} from "axios";
import {PointsResponse} from "@/api/[models]/pointsResponses";
import {PickUpPointRequest} from "@/api/[models]/pointsRequests";

export default class PointsService {
    static async getAllPoints(): Promise<AxiosResponse<Partial<PointsResponse[]>>> {
        return api.get<Partial<PointsResponse[]>>('/points');
    }

    static async createNewPoint(point: PickUpPointRequest): Promise<AxiosResponse> {
        return api.post('/points', point);
    }

    static async updatePoint(newPoint: PickUpPointRequest, pointId: number): Promise<AxiosResponse> {
        return api.patch(`/points/${pointId}`, newPoint);
    }
}