fill -2491 319 -401 -2491 319 -447 air
fill -2491 318 -401 -2491 318 -447 air
function modden:has_orb/true
tp @a[limit=1,team=owner] -2564 65 -413
execute at @a[limit=1,team=owner] run fill ~-1 ~-3 ~-1 ~1 ~-3 ~1 bedrock
tp @a @a[limit=1,team=owner]
effect give @a minecraft:weakness 10 100 true
effect give @a minecraft:resistance 10 10 true
effect give @a dolphins_grace 15 0 true
setworldspawn -2564 65 -413
spawnpoint @a -2564 65 -413
worldborder set 20000 1
title @a title "The game has started!"
playsound entity.ender_dragon.ambient ambient @a ~ ~ ~ 1 1
gamemode survival @a
give @a baked_potato 16
time set day
gamerule doDaylightCycle true
gamerule doWeatherCycle true