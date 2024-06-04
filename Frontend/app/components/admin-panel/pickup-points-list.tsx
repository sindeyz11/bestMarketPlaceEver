"use client";

import authStore from "@/store/auth";
import { PickupPointItem } from "./pickup-point-item";
import { Button } from "../ui/button";
import { useState } from "react";
import Modal from "../layout/modal";
import { AddingPickupPoint } from "./adding-pickup-point";

export const PickupPointsList = () => {
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleOpenModal = () => {
    setIsModalOpen(true);
  };

  const handleCloseModal = () => {
    setIsModalOpen(false);
  };
  return (
    <div className="bg-white shadow-lg rounded-xl p-6 ">
      <Modal isOpen={isModalOpen} onClose={handleCloseModal}>
        <div className="h-full w-full flex flex-col">
          <div className="flex flex-col gap-3">
            <h3 className="font-semibold text-xl text-center">
              Добавить пункт выдачи
            </h3>
            <AddingPickupPoint />
            <div className="flex items-center gap-3 w-full">
              <Button color="gray" onClick={() => handleCloseModal()}>
                Отмена
              </Button>
              <Button color="dark">Добавить</Button>
            </div>
          </div>
        </div>
      </Modal>
      <h2 className="text-black font-semibold text-lg mb-2">Пункты выдачи</h2>
      {authStore.pickupPoints.length ? (
        <div className="flex flex-col gap-3">
          {authStore.pickupPoints.map((pickupPoint) => (
            <PickupPointItem
              code={pickupPoint.code}
              address={pickupPoint.address}
              manager={pickupPoint.manager}
              income={pickupPoint.income}
            />
          ))}
          <Button color="dark" onClick={() => handleOpenModal()}>
            Добавить
          </Button>
        </div>
      ) : (
        <div className="h-[300px] flex flex-col items-center justify-between">
          <p className="text-secondary-text/40 grow-0 h-full flex items-center justify-center">
            Пункты выдачи отсутсвуют
          </p>
          <Button color="dark" onClick={() => handleOpenModal()}>
            Добавить
          </Button>
        </div>
      )}
    </div>
  );
};
