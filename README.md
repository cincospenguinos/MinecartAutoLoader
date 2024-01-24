# MinecartAutoLoader

I have a really crappy machine that my minecraft server runs on, so I keep the view distance down to like a 3. That also
means that a storage minecart going three chunks away won't reach its destination, defeating its purpose. To ameliorate
that, this Spigot plugin will keep all the chunks a storage minecart moves into loaded all the time, making your
storage minecart setup work forever.

Note that it is quite memory intensive, as it keeps a bunch of chunks loaded all the time until the storage minecart
associated is destroyed.
