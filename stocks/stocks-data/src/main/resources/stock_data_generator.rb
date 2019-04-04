require "date"

# "Stock,date,currentprice,openingprice,closingprice,daylow,dayhigh\n"

#Get the stock name
puts "Please enter the stock name:"
stock_name = gets
stock_name = stock_name.chomp
stock = stock_name

#Calculate the today's date
time = Time.new
today_date = "#{time.year}" + "-" + "#{time.month}" + "#{time.day}"
current_date = Date.parse today_date

#Get the opening price in the opening date
puts "Please enter the opening price:"
opening_price = gets
opening_price = opening_price.to_s
opening_price = opening_price.chomp

#Calculate the days high
day_high = "#{opening_price}".to_i + rand(30..150)

#Calculate the days low
day_low = "#{opening_price}".to_i - rand(30..150)

#Caculate the current price and closing price - between day high and day low
current_price = rand("#{day_low}".to_i.."#{day_high}".to_i)
closing_price = rand("#{day_low}".to_i.."#{day_high}".to_i)

# Append to the stock database - Stock,date,currentprice,openingprice,closingprice,daylow,dayhigh
open('stock_database.txt', 'a') do |f|  
  f << "#{stock}," + "#{current_date}," + "#{current_price}," + "#{opening_price}," + "#{closing_price}," + "#{day_low}," + "#{day_high}\n"
  
  #Calculate the next ten days prices
  for i in 2..10
   
  #Next day opening price is previous day closing price
  opening_price = "#{closing_price}".to_i
  
  #Calculate the today's date
  current_date = current_date.next_day

  
  #Calculate the days high
  day_high = "#{opening_price}".to_i + rand(30..150)

  #Calculate the days low
  day_low = "#{opening_price}".to_i - rand(30..150)

  #Caculate the current price and closing price - between day high and day low
  current_price = rand("#{day_low}".to_i.."#{day_high}".to_i)
  closing_price = rand("#{day_low}".to_i.."#{day_high}".to_i)

  #Append the next day price of the stock
  f << "#{stock}," + "#{current_date}," + "#{current_price}," + "#{opening_price}," + "#{closing_price}," + "#{day_low}," + "#{day_high}\n"
  end
end