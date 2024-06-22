import { PasswordIcon } from "@/components/icons/password-icon";
import { RepeatPasswordIcon } from "@/components/icons/repeat-password-icon";
import { Button } from "@/components/ui/button";
import { Field } from "@/components/ui/field";
import { useState } from "react";
import UserService from "@/app/api/user-service";
import toast from "react-hot-toast";
import authorizedUserStore from "@/store/authorizedUser";
import { IUserRole } from "@/types";
import { useRouter } from "next/navigation";
import { useMutation } from "@tanstack/react-query";

export const ChangePasswordPanel = () => {
  const router = useRouter();
  const [oldPassword, setOldPassword] = useState<string>("");
  const [newPassword, setNewPassword] = useState<string>("");
  const [repeatedNewPassword, setRepeatedNewPassword] = useState<string>("");

  const updateMutation = useMutation({
    mutationKey: ["password"],
    mutationFn: async () => {
      return await UserService.changePassword(
        oldPassword,
        newPassword,
        repeatedNewPassword,
      );
    },
    onSuccess: () => {
      toast.success("Пароль успешно обновлен");
    },
    onError: () => {
      toast.error("Произошла ошибка при обновлении пароля");
    },
  });
  const handleUpdate = async (event: any) => {
    event.preventDefault();
    updateMutation.mutate();
  };
  return (
    <div className="rounded-xl bg-white p-6 shadow-lg">
      <form className="flex flex-col gap-2">
        <h2 className="text-center text-lg font-semibold text-black">
          Изменить пароль
        </h2>
        <Field
          icon={<PasswordIcon className="text-dark-accent" />}
          placeholder="Старый пароль"
          value={oldPassword}
          type="password"
          onChange={(e) => setOldPassword(e.target.value)}
        />
        <Field
          icon={<PasswordIcon />}
          placeholder="Новый пароль"
          value={newPassword}
          type="password"
          onChange={(e) => setNewPassword(e.target.value)}
        />
        <Field
          icon={<RepeatPasswordIcon />}
          placeholder="Повторите пароль"
          value={repeatedNewPassword}
          type="password"
          onChange={(e) => setRepeatedNewPassword(e.target.value)}
        />
        <div className="mt-4">
          <Button color="dark" onClick={(event) => handleUpdate(event)}>
            Обновить пароль
          </Button>
        </div>
      </form>
    </div>
  );
};
