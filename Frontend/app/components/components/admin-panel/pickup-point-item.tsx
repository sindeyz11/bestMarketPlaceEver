"use client"
import authStore from "@/store/auth"
import { IPickupPoint } from "@/types"
import { formatNumber } from "@/utils"
import { observer } from "mobx-react-lite"
import { TrashIcon } from "../icons/trash-icon"
import { Button } from "../ui/button"

export const PickupPointItem = observer(
	({ code, address, manager, income }: IPickupPoint) => {
		return (
      <div className="bg-secondary-bg p-4 rounded-lg relative">
        <div className="absolute top-3 right-3">
          <Button
            variant="icon"
            icon={<TrashIcon />}
            onClick={() => authStore.removePickupPoint(code)}
          />
        </div>
        <div className="flex flex-col gap-2">
          <div className="flex flex-col gap-0.5 leading-none">
            <h3 className="text-xl font-light">{code}</h3>
            <p className="text-secondary-text text-sm">{address}</p>
          </div>
          <div className="flex flex-col gap-0.5 leading-none">
            <span className="font-semibold">Менеджер</span>
            <span className="text-sm">
              {manager.name}{" "}
              <span className="text-secondary-text">({manager.code})</span>
            </span>
            <div className="flex items-center justify-between">
              <span className="font-semibold">Доход</span>
              <span className="text-xl text-secondary-text">
                ₽{formatNumber(income)}
              </span>
            </div>
          </div>
        </div>
      </div>
    );
	}
)
