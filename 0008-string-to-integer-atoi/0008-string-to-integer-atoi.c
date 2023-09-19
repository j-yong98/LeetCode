
int	is_digit(char ch)
{
	if (ch >= '0' && ch <= '9')
		return (1);
	return (0);
}

int	to_int(char *str, int sign)
{
	long long	res;

	res = 0;
	while (is_digit(*str))
	{
        res *= 10;
        res += (*str) - '0';
        if (res >= 2147483647 && sign > 0) return 2147483647;
        else if (res >= 2147483648 && sign < 0) return -2147483648;
        printf("%d\n", res);
		str++;
	}
	return ((int)(res) * sign);
}

int	is_space(char ch)
{
	if (ch == ' ' || ch == '\n' || ch == '\t')
		return (1);
	if (ch == '\v' || ch == '\f' || ch == '\r')
		return (1);
	return (0);
}

int	myAtoi(char *str)
{	
	int	sign_cnt;
	int	res;
    int cnt;

	while (is_space(*str))
		str++;
	sign_cnt = 1;
    cnt = 0;
	while (*(str) && !is_digit(*str))
	{
		if (*str != '+' && *str != '-')
			return (0);
		if (*str == '-')
			sign_cnt *= -1;
        if (cnt > 0) return 0;
        cnt++;
		str++;
	}
	res = to_int(str, sign_cnt);
    printf("%d", res);
	return (res);
}