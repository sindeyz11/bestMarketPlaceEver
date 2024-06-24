"use client";
import authStore from "@/store/auth";
import { IPickupPoint } from "@/types";
import { formatNumber } from "@/utils";
import { observer } from "mobx-react-lite";
import { TrashIcon } from "../icons/trash-icon";
import { Button } from "../ui/button";
import { formatId } from "@/utils/format-id";

export const PickupPointItem = observer(
  ({ code, address, manager, income }: IPickupPoint) => {
    return (
      <div className="relative rounded-lg bg-secondary-bg p-4">
        <div className="absolute right-3 top-3">
          <Button
            variant="icon"
            icon={<TrashIcon />}
            // onClick={() => authStore.removePickupPoint(code)}
          />
        </div>
        <div className="flex flex-col gap-2">
          <div className="flex flex-col gap-0.5 leading-none">
            <h3 className="text-xl font-light">КРД-{formatId(code)}</h3>
            <p className="text-sm text-secondary-text">{address}</p>
          </div>
          <div className="flex flex-col gap-0.5 leading-none">
            <span className="font-semibold">Менеджер</span>
            <span className="text-sm">{manager}</span>
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
  },
);
