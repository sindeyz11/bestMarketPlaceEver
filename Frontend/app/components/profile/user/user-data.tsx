import { EmailIcon } from "@/components/icons/email-icon"
import { PhoneIcon } from "@/components/icons/phone-icon"
import { UserIcon } from "@/components/icons/user-icon"
import { Button } from "@/components/ui/button"
import { Field } from "@/components/ui/field"
import { useState } from "react"

interface UserDataProps {
  usernameData?: string;
  phoneData?: string;
  emailData?: string;
}

export const UserData = ({usernameData, phoneData, emailData}: UserDataProps) => {
    const [username, setUsername] = useState<string>(usernameData || "")
    const [phone, setPhone] = useState<string>(phoneData || "")
    const [email, setEmail] = useState<string>(emailData || "")
    return <div className="bg-white shadow-lg rounded-xl p-6">
    <form className="flex flex-col gap-2">
      <h2 className="text-black font-semibold text-lg text-center">
        Данные профиля
      </h2>
      <Field
        icon={<UserIcon />}
        placeholder="Имя_пользователя"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />
      <Field
        icon={<PhoneIcon />}
        placeholder="000 000 00-00"
        value={phone}
        onChange={(e) => setPhone(e.target.value)}
        startContent="+7"
      />
      <Field
        icon={<EmailIcon />}
        placeholder="example@kubmarket.ru"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <div className="mt-4">
        <Button color="dark">Сохранить</Button>
      </div>
    </form>
  </div>
}