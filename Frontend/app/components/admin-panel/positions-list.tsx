"use client";

import { IPositionItem } from "@/types";
import { Button } from "../ui/button";
import { PositionItem } from "./position-item";
import Modal from "../layout/modal";
import { useState } from "react";

interface PositionsListProps {
  positions: IPositionItem[];
}

export const PositionsList = ({ positions }: PositionsListProps) => {
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleOpenModal = () => {
    setIsModalOpen(true);
  };

  const handleCloseModal = () => {
    setIsModalOpen(false);
  };
  return (
    <div className="rounded-xl bg-white p-6 shadow-lg">
      <Modal isOpen={isModalOpen} onClose={handleCloseModal}>
        <div className="flex h-full w-full flex-col">
          <div className="flex flex-col gap-3">
            <h3 className="text-center text-xl font-semibold">
              Добавить позицию
            </h3>
            <PositionItem />
            <div className="flex w-full items-center gap-3">
              <Button color="gray" onClick={() => handleCloseModal()}>
                Отмена
              </Button>
              <Button color="dark">Добавить</Button>
            </div>
          </div>
        </div>
      </Modal>
      <h2 className="mb-2 text-lg font-semibold text-black">Позиции</h2>
      {positions.length ? (
        <div className="flex flex-col gap-4">
          <div className="custom-scroll flex h-[calc(100dvh-300px)] flex-col gap-3 overflow-y-auto rounded-xl">
            {positions.map((position) => (
              <PositionItem
                key={position.id}
                id={position.id}
                title={position.title}
                price={position.price}
                discountPrice={position.discountPrice}
                unit={position.unit}
                availableQuantity={position.availableQuantity}
                description={position.description}
                image={position.image}
                category={position.category}
              />
            ))}
          </div>
          <Button color="dark" onClick={() => handleOpenModal()}>
            Добавить
          </Button>
        </div>
      ) : (
        <div className="flex min-h-[calc(100%-30px)] flex-col">
          <div className="flex grow items-center justify-center">
            <p className="text-black/40">Позиции отсутствуют</p>
          </div>
          <Button color="dark" onClick={() => handleOpenModal()}>
            Добавить
          </Button>
        </div>
      )}
    </div>
  );
};
